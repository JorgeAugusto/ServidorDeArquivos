/**
 * Classe tem métodos auxiliares para o trabalho com a JTable.
 * @author: Jorge Augusto C. dos Reis
 * @data..: 17/03/2013 às 23:14
 * @Descrição:
 * Esta classe implemente métodos auxiliares para o trabalho com o JTable
 */

package base;

import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JViewport;

public class JTableUtils
{
    // Seleciona  e rola a barra!
    public static void selectAndScroll(JTable table, int rowIndex)
    {
        table.getSelectionModel().setSelectionInterval(rowIndex, rowIndex);
        scrollToVisible(table, rowIndex);
    }


    // Rola para a linha visível
    public synchronized static void scrollToVisible(JTable table, int rowIndex)
    {
        scrollToVisible(table, rowIndex, 0);
    }

    // Rola para a linha visível
    public static void scrollToVisible(JTable table, int rowIndex, int vColIndex)
    {
        if (!(table.getParent() instanceof JViewport)) return;
        setViewPortPosition((JViewport) table.getParent(), table.getCellRect(rowIndex, vColIndex, true));
    }


    // Configura a parte visível
    private static void setViewPortPosition(JViewport viewport, Rectangle position)
    {
        Point pt = viewport.getViewPosition();
        position.setLocation(position.x - pt.x, position.y - pt.y);
        viewport.scrollRectToVisible(position);
    }

    // Rola barra para mostrar a seleção
    public static void scrollToSelection(JTree tree)
    {
        if (!(tree.getParent() instanceof JViewport)) return;
        setViewPortPosition((JViewport) tree.getParent(), tree.getPathBounds(tree.getSelectionPath()));
    }
}
