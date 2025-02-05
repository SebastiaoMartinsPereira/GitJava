import java.util.ArrayList;
import java.util.List;

 
public class Jogador {
	
	private List<Carta> cartas = new ArrayList<Carta>();
	
	private int pontos;
	
	
	public Jogador(){
		this.pontos = 0;
		this.cartas.removeAll(cartas);
	}
	
	
    public void somaPontos(int pontos){
    	this.pontos += pontos;
	}
	
	public int mostraPontos(){	
		return pontos;
	}
	
	public void joga(Carta carta){
		this.setCartas(carta);
		this.somaPontos(carta.getFace().getValor());
	}
	
	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(Carta cartas) {
		this.cartas.add(cartas);
	}
	
}
