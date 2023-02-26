package main

import (
	"encoding/json"
	"fmt"
	"log"
	"math/rand"
	"net/http"
	"os"
)

type tempResponse struct {
	Temperature int    `json:"temperature"`
	SensorUuid  string `json:"sensor_uuid"`
}

func newTempResponse(temperature int, sensorUuid string) *tempResponse {
	return &tempResponse{Temperature: temperature, SensorUuid: sensorUuid}
}

func sensorHandler(w http.ResponseWriter, r *http.Request) {
	min := -15
	max := 0
	temperature := rand.Intn(max-min) + min
	tResponse := newTempResponse(temperature, os.Getenv("SENSOR_UUID"))
	err := json.NewEncoder(w).Encode(tResponse)
	if err != nil {
		log.Printf("ERROR: Unable to get temperature measuresments, %s", err.Error())
		w.WriteHeader(500)
	} else {
		w.WriteHeader(200)
	}
}

func main() {
	port, isPresent := os.LookupEnv("SERVER_PORT")
	if !isPresent {
		port = ":8080"
	} else {
		port = fmt.Sprintf(":%s", port)
	}
	http.HandleFunc("/temperature", sensorHandler)
	log.Printf("Server started on port %s", port)
	err := http.ListenAndServe(port, nil)
	if err != nil {
		panic(err)
	}
}
