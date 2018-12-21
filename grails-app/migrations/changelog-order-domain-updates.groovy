databaseChangeLog = {

    changeSet(author: "ramesh (generated)", id: "1545388861995-1") {
        addColumn(tableName: "order_item") {
            column(name: "count", type: "integer") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ramesh (generated)", id: "1545388861995-2") {
        addColumn(tableName: "order_item") {
            column(name: "item_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ramesh (generated)", id: "1545388861995-3") {
        addColumn(tableName: "order_item") {
            column(name: "item_price", type: "double precision") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ramesh (generated)", id: "1545388861995-4") {
        addColumn(tableName: "order_item") {
            column(name: "order_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ramesh (generated)", id: "1545388861995-5") {
        addColumn(tableName: "order_item") {
            column(name: "total_price", type: "double precision") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ramesh (generated)", id: "1545388861995-6") {
        addColumn(tableName: "order") {
            column(name: "user_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ramesh (generated)", id: "1545388861995-7") {
        addForeignKeyConstraint(baseColumnNames: "item_id", baseTableName: "order_item", constraintName: "FK187gqnsawob9guk17n8mmml72", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product")
    }

    changeSet(author: "ramesh (generated)", id: "1545388861995-8") {
        addForeignKeyConstraint(baseColumnNames: "order_id", baseTableName: "order_item", constraintName: "FKt6wv8m7eshksp5kp8w4b2d1dm", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "order")
    }

    changeSet(author: "ramesh (generated)", id: "1545388861995-9") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "order", constraintName: "FKt7abetueht6dd1gs9jyl3o4t7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user")
    }
}
