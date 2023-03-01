db.createUser(
    {
        user: "tempuser",
        pwd: "crackme",
        roles: [
            {
                role: "readWrite",
                db: "tempdb"
            }
        ]
    }
);
db = new Mongo().getDB("tempdb");

db.createCollection(
    "temperature",
    {
        timeseries: {
            timeField: "timestamp",
            metaField: "sensor",
            granularity: "seconds"
        }
    }
)