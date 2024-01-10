package Projeto;
import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
public class Run {
	public static void main(String[] args) throws IOException,InterruptedException {
		int o = 0;
		int i;
		int d = 0;
		int v = 0;
		int e = 0;
		int p = 0;
		List<clube> club = new ArrayList<>();
		List<String> og = new ArrayList<>();
		campeonato go = new campeonato();
		Scanner sn = new Scanner(System.in);
		System.out.println("Bem vindo á aplicação de simulação fotubulastica");
		while ( o == 0 ) {
		clube a = new clube();
		clube a1 = new clube();
		jogador j = new jogador();
		List<jogador> jo = new ArrayList<>();
		System.out.println("1-Criar clube" + "\n" + "2-Criar jogador(s)" + "\n" + "3-Ver os clubes" + "\n" + "4-Ver jogadores criados" + "\n" +"5-Criar campeonato" + "\n" +"6-Criar partidas" + "\n" +"7-Ver jogos criados" + "\n" +"0-Sair da app");
		Scanner f = new Scanner(System.in);
		int g = f.nextInt();
		switch (g) {
		case 1:{
			club.add(a.getclube(a));
			System.out.print(club.get(0));
			for (i = 0; i < 50; ++i) System.out.println();
			break;
		}
		case 3: {
			for (i = 0; i < 50; ++i) System.out.println();
			for (i = 0; i < club.size() ; i++) {
				clube c = club.get(i);
				if (c == null) {
					break;
				}
				else {
				System.out.println ("O clube " + c.getNome() + " foi criado em " + c.getDatadefundacao() + " , em " + c.getPais() + " na cidade " + c.getCidade() + " , o seu treinador é " + c.getTreinador() + "\n" + "lista de jogadores:" + "\n" + c.getListadejogadores(jo) + "\nVitorias = desconhecido"  + "\nEmpates = desconhecido"  + "\nDerrota = desconhecido" );
			}
			}
			System.out.print("\n");
			break;
			}
		case 2: {
			for (i = 0; i < 50; ++i) System.out.println();
			System.out.println("Quantos jogadores quer adiciona");
			int h = f.nextInt();
			for (i = 0; i < h; i++) {
				j.setJogador(j);
				System.out.println("A que club deseja adicionar o jogador");
				String l = sn.nextLine();
				clube pla = null;
				for (i = 0 ; i < club.size(); i ++) {
					a = club.get(i);
					if (a.getNome().equals(l)) {
						pla = a;
					}	
				}
				if (pla != null) {
					pla.addjogador(j);
				} else {
					System.out.println("Clube não existe");
				}
				
			}
			System.out.print("\n");
			break;
		}
		case 4: {
			for (i = 0; i < 50; ++i) System.out.println();
			System.out.println("De que club quer ver a lista de jogadores?");
			String l = sn.nextLine();
			clube pla = null;
			for (i = 0 ; i < club.size(); i ++) {
				a = club.get(i);
				if (a.getNome().equals(l)) {
					pla = a;
				}	
			}
			if (pla != null) {
				pla.getListadejogadores(jo);
			} else {
				System.out.println("Clube não existe");
			}
			System.out.print("\n");
			break;
		}
		case 5: {
			for (i = 0; i < 50; ++i) System.out.println();
			System.out.println("Qual é o nome do campeonato");
			String b = sn.nextLine();
			go.setNome(b);
			System.out.println("Em que pais se passa o campeonato");
			String b1 = sn.nextLine();
			go.setPais(b1);
			break;
		}
		case 6: {
			for (i = 0; i < 50; ++i) System.out.println();
			go.setListaclub(club);
			System.out.println("Quem é o primeiro clube a jogar");
			String l = sn.nextLine();
				while(p == 0) {
				
				clube pla = null;
				for (i = 0 ; i < club.size(); i ++) {
					a = club.get(i);
					if (a.getNome().equals(l)) {
						pla = a;
					}	
				}
				if (pla != null) {
					p += 1;
				} else {
					System.out.println("Clube não existe");
					String l4 = sn.nextLine();
					l = l4;
				}
				}
			System.out.println("Quem é o Segundo clube a jogar");
			String l1 = sn.nextLine();
				while(p == 0) {
					
					clube pla = null;
					for (i = 0 ; i < club.size(); i ++) {
						a1 = club.get(i);
						if (a1.getNome().equals(l1)) {
							pla = a1;
						}	
					}
					if (pla != null) {
						p += 1;
					} else {
						System.out.println("Clube não existe");
						String l5 = sn.nextLine();
						l1 = l5;
					}
					}
				System.out.println("Como ficou o placar do jogo?");
				System.out.println("1º equipa");
				int l2 = sn.nextInt();
				System.out.println("2º equipa");
				int l3 = sn.nextInt();
				go.insirtGestaotabela(og, a, a1, l2, l3);
				og.add(l + " " + l2 + "-" + l3 + " " + l1);
				if (l2 > l3) {
					a.getResultados(1);
					a1.getResultados(2);
				} else if (l2 < l3) {
					a.getResultados(2);
					a1.getResultados(1);
				} else {
					a.getResultados(3);
					a1.getResultados(3);
				}
				break;
			}
		case 7: {
			for (i = 0; i < 50; ++i) System.out.println();
			go.getGestaotabela(og);
			break;
		}
		
		case 0:{
			o = 1;
			break;
		}		
}
		
}
}
}