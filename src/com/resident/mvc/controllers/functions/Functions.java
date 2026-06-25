package com.resident.mvc.controllers.functions;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public abstract class Functions {
    
    public int getSelectedID(JTable table) {
        if (table == null) return -1;
        return table.getSelectedRow();
    }
    
    //Si se suveeeeee es magiaaaaaaaaaaaaa
}