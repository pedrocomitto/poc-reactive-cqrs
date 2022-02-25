db.createUser(
        {
            user: "dborder",
            pwd: "dborder",
            roles: [
                {
                    role: "readWrite",
                    db: "dbordercommand"
                }
            ]
        }
);