FROM golang:1.19-buster AS builder

WORKDIR "/go/src/app"

COPY . .

RUN GO111MODULE=on CGO_ENABLED=1 GOOS=linux go build -o /temperature-sensor main.go

FROM debian:stable-slim as prod

COPY --from=builder "/temperature-sensor" .

RUN apt update -y && apt install -y libc6

RUN echo 'DPkg::Post-Invoke {"/bin/rm -f /var/cache/apt/archives/*.deb || true";};' | tee /etc/apt/apt.conf.d/clean

CMD ./temperature-sensor
