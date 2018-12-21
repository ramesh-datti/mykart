databaseChangeLog = {

    changeSet(author: "ramesh (generated)", id: "1545393772765-1") {
        addColumn(tableName: "myorders") {
            column(name: "total_order_price", type: "double precision") {
                constraints(nullable: "false")
            }
        }
    }
}
