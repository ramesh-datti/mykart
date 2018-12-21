databaseChangeLog = {

    changeSet(author: "ramesh (generated)", id: "1545392497546-1") {
        createTable(tableName: "myorders") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "myordersPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ramesh (generated)", id: "1545392497546-2") {
        addForeignKeyConstraint(baseColumnNames: "order_id", baseTableName: "order_item", constraintName: "FKjmpxfaa3dvg5kqjpqh222fmdh", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "myorders")
    }

    changeSet(author: "ramesh (generated)", id: "1545392497546-3") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "myorders", constraintName: "FKmr283jgkxpwpm7n1uu3alhr4q", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user")
    }

    changeSet(author: "ramesh (generated)", id: "1545392497546-4") {
        dropForeignKeyConstraint(baseTableName: "order_item", constraintName: "FKt6wv8m7eshksp5kp8w4b2d1dm")
    }

    changeSet(author: "ramesh (generated)", id: "1545392497546-5") {
        dropForeignKeyConstraint(baseTableName: "order", constraintName: "FKt7abetueht6dd1gs9jyl3o4t7")
    }

    changeSet(author: "ramesh (generated)", id: "1545392497546-6") {
        dropTable(tableName: "order")
    }
}
