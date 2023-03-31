import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    public void cria(InputStream inputStream, String nomeDoArquivo) throws Exception {
        // FileInputStream inputStream = new FileInputStream(new File("entrada/TopMovies_1.jpg"));
        // InputStream inputStream =  new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        BufferedImage original = ImageIO.read(inputStream);
        int largura = original.getWidth();
        int altura = original.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(original, 0, 0, null);
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        graphics.drawString("TOPZERA", largura / 4, (altura + (novaAltura - altura) / 2) + 20);
        ImageIO.write(novaImagem, "png", new File("saida/"+nomeDoArquivo));
    }
}
