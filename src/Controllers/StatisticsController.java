package Controllers;

import Managers.EmpruntData;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class StatisticsController {
    private EmpruntData empruntData = new EmpruntData();
    public void plotchart(JPanel parent,String email){
        try {
            if(email != null){
                System.out.println("removed");
                parent.remove(1);
            }
            DefaultCategoryDataset data = empruntData.getPlotData(email);
            if(data == null && email != null){
                JOptionPane.showMessageDialog(null,"No student found with this email !","Information",JOptionPane.INFORMATION_MESSAGE);
            }
            var chart = ChartFactory.createBarChart("Loans by student",
                    " ", " " , data, PlotOrientation.VERTICAL,true,true,false);
            chart.setBackgroundPaint(UIManager.getColor ("Panel.background"));
            chart.getPlot().setBackgroundPaint( UIManager.getColor ("Panel.background"));
            chart.getTitle().setPaint(UIManager.getColor ("Label.foreground"));
            chart.getPlot().setOutlinePaint(UIManager.getColor ("Panel.background"));
            chart.getLegend().setBackgroundPaint(UIManager.getColor ("Panel.background"));
            chart.getLegend().setFrame(new BlockBorder(UIManager.getColor ("Label.foreground")));
            chart.getLegend().setItemPaint(UIManager.getColor ("Label.foreground"));
            var plot = (CategoryPlot)chart.getPlot();
            var range = plot.getRangeAxis();
            var domain = plot.getDomainAxis();
            domain.setTickLabelPaint(UIManager.getColor ("Label.foreground"));
            range.setTickLabelPaint(UIManager.getColor ("Label.foreground"));
            UIManager.addPropertyChangeListener(e->{
                chart.setBackgroundPaint(UIManager.getColor ("Panel.background"));
                chart.getPlot().setBackgroundPaint( UIManager.getColor ("Panel.background"));
                chart.getTitle().setPaint(UIManager.getColor ("Label.foreground"));
                chart.getPlot().setOutlinePaint(UIManager.getColor ("Panel.background"));
                domain.setTickLabelPaint(UIManager.getColor ("Label.foreground"));
                range.setTickLabelPaint(UIManager.getColor ("Label.foreground"));
                chart.getLegend().setBackgroundPaint(UIManager.getColor ("Panel.background"));
                chart.getLegend().setFrame(new BlockBorder(UIManager.getColor ("Label.foreground")));
                chart.getLegend().setItemPaint(UIManager.getColor ("Label.foreground"));
            });
            ChartPanel chartPanel = new ChartPanel(chart,true);
            chartPanel.setPreferredSize(new Dimension(500,400));
            chartPanel.setMaximumSize(new Dimension(500,400));

            parent.add(chartPanel);
            parent.invalidate();
            parent.validate();
            parent.repaint();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void piechart(JPanel parent){
        try {
            DefaultPieDataset Pie = empruntData.getPieData();
            var chart = ChartFactory.createPieChart("Top loan materials", Pie,
                    true, true , true);
            chart.setBackgroundPaint(UIManager.getColor ("Panel.background"));
            chart.getPlot().setBackgroundPaint( UIManager.getColor ("Panel.background"));
            chart.getTitle().setPaint(UIManager.getColor ("Label.foreground"));
            chart.getPlot().setOutlinePaint(UIManager.getColor ("Panel.background"));
            chart.getLegend().setBackgroundPaint(UIManager.getColor ("Panel.background"));
            chart.getLegend().setFrame(new BlockBorder(UIManager.getColor ("Label.foreground")));
            chart.getLegend().setItemPaint(UIManager.getColor ("Label.foreground"));
            UIManager.addPropertyChangeListener(e->{
                chart.setBackgroundPaint(UIManager.getColor ("Panel.background"));
                chart.getPlot().setBackgroundPaint( UIManager.getColor ("Panel.background"));
                chart.getTitle().setPaint(UIManager.getColor ("Label.foreground"));
                chart.getPlot().setOutlinePaint(UIManager.getColor ("Panel.background"));
                chart.getLegend().setBackgroundPaint(UIManager.getColor ("Panel.background"));
                chart.getLegend().setFrame(new BlockBorder(UIManager.getColor ("Label.foreground")));
                chart.getLegend().setItemPaint(UIManager.getColor ("Label.foreground"));
            });
            ChartPanel chartPanel = new ChartPanel(chart,true);
            chartPanel.setPreferredSize(new Dimension(500,400));
            chartPanel.setMaximumSize(new Dimension(500,400));

            parent.add(chartPanel);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}