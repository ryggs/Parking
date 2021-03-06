package parking.server.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import parking.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PriceDAO {

    public static ObservableList<Price> getAllPrices() throws SQLException {
        String stmt = "SELECT * FROM prices";
        ResultSet rs = null;
        try {
            rs= DBUtil.dbExecuteQuery(stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ObservableList<Price> list = FXCollections.observableArrayList();

        while (rs.next()) {
            int id = rs.getInt(1);
            String priceName = rs.getString(2);
            String priceType = rs.getString(3);
            Integer pricePrice = rs.getInt(4);
            Integer priceDuration = rs.getInt(5);



            Price p = new Price(id, priceName, priceType, pricePrice, priceDuration);
            list.add(p);
        }
        return list;


    }

    public static void update(int index, String columnName, String newValue) throws SQLException {


        String stmt = "UPDATE prices SET `"+ columnName +"` = '" +newValue+ "' WHERE `id` = " + index;

        DBUtil.dbExecuteUpdate(stmt);


    }
}
