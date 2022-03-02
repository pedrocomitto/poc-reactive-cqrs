db.createUser(
        {
            user: "order",
            pwd: "order",
            roles: [
                {
                    role: "readWrite",
                    db: "dborderquery"
                }
            ]
        }
);