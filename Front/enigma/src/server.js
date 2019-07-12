const express = require("express");
const bodyParser = require("body-parser");
const database = require("./database");
const cors = require("cors");

const app = express();

const port = process.env.PORT || 5000;

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(cors());


app.delete("/user", (req, res) => {
    database.deleteUser((err, dataset) => {
        if (err) return res.status(500).send(err);
        return res.status(200).send(dataset);
    }, req.body.userName);
});


app.patch("/user", (req, res) => {
    database.updatePassword((err, dataset) => {
        if (err) return res.status(500).send(err);
        else return res.status(200).send(dataset);
    }, req.body);
});

