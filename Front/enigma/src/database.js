const mysql = require("mysql");

const connection = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: " ",
    database: "enigma"
});


const deleteUser = (clbk, userName) => {
    const sql = "DELETE FROM person WHERE userName = ?";

    connection.query(sql, [userName], function(err, res) {
        if (err) return clbk(res, null);
        return clbk(null, res);
    });
};

const updatePassword = (callback, data) => {
    const sql =
        "UPDATE person SET password= ? WHERE userName = ?";
    const payload = [
        data.password,
        data.userName
    ];

    connection.query(sql, payload, (err, res) => {
        if (err) return callback(err, null);
        return callback(null, res);
    });
};

module.exports = {
    deleteUser,
        updatePassword
}