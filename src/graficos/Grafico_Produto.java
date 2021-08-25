package graficos;

import java.util.List;

import javax.swing.JFrame;
import model.dao.VendaDAO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico_Produto extends JFrame {

    private static final long serialVersionUID = 1L;

    VendaDAO vd = new VendaDAO();

    public Grafico_Produto() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Gráficos");
        setSize(950, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
//
//    public static void main(String[] args) {
//        LocalDate homemNoEspaco = LocalDate.of(1999, Month.OCTOBER, 31);
//        LocalDate homemNaLua = LocalDate.of(2018, Month.NOVEMBER, 24);
//
//        Period periodo = Period.between(homemNoEspaco, homemNaLua);
//
//        System.out.printf("%s anos, %s mês e %s dias",
//                periodo.getYears(), periodo.getMonths(), periodo.getDays());
//
//        LocalDate hoje = LocalDate.now();
//        System.out.println("Hoje: " + hoje.getDayOfMonth() + "/" + hoje.getMonth() + "/" + hoje.getYear());
//        LocalDate ontem = hoje.minusDays(1);
//        System.out.println("Ontem: " + ontem.getDayOfMonth() + "/" + ontem.getMonthValue() + "/" + ontem.getYear());
//    }

    public void criarGrafico(List<String> nomes, List<Double> qtd, String nome, String quantidade, String titulo) {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();

        for (int i = 0; i < nomes.size(); i++) {
            ds.setValue(qtd.get(i), nome, nomes.get(i));
        }

        JFreeChart grafico = ChartFactory.createBarChart3D("Gráfico de " + titulo, nome, quantidade, ds, PlotOrientation.HORIZONTAL, true, true, false);

        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }
}
