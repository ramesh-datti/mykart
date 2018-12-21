databaseChangeLog = {

    changeSet(author: "ramesh (generated)", id: "1545383268176-1") {
        createTable(tableName: "cart") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "cartPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ramesh (generated)", id: "1545383268176-2") {
        createTable(tableName: "cart_item") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "cart_itemPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "item_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "cart_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "count", type: "INT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ramesh (generated)", id: "1545383268176-3") {
        createTable(tableName: "order") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "orderPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ramesh (generated)", id: "1545383268176-4") {
        createTable(tableName: "order_item") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "order_itemPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ramesh (generated)", id: "1545383268176-5") {
        createTable(tableName: "product") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "productPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "price", type: "DOUBLE") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "ramesh (generated)", id: "1545383268176-6") {
        addForeignKeyConstraint(baseColumnNames: "cart_id", baseTableName: "cart_item", constraintName: "FK1uobyhgl1wvgt1jpccia8xxs3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "cart")
    }

    changeSet(author: "ramesh (generated)", id: "1545383268176-7") {
        addForeignKeyConstraint(baseColumnNames: "item_id", baseTableName: "cart_item", constraintName: "FK924v2k9shuysam0ee0lo5yb43", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product")
    }

    changeSet(author: "ramesh (generated)", id: "1545383268176-8") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "cart", constraintName: "FKl70asp4l4w0jmbm1tqyofho4o", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user")
    }
}
