package br.com.tayana.enums;

public enum TimesEnum {

	ATLETICOMG(1), ATLETICOPR(2), BAHIA(3), BANGU(4), BOTAFOGO(5), BRAGANTINO(6), BRASILIENSE(7), CEARA(8),
	CHAPECOENSE(9), CORINTHIANS(10), CORITIBA(11), CRICIUMA(12), CRUZEIRO(13), CSA(14), FIGUEIRENSE(15), FLAMENGO(16),
	FLUMINENSE(17), FORTALEZA(18), GOIAS(19), GREMIO(20), GUARANI(21), INTER(22), JUVENTUDE(23), NAUTICO(24),
	PALMEIRAS(25), PAULISTA(26), PAYSANDU(27), PONTEPRETA(28), PORTUGUESA(29), SANTOANDRE(30), SANTOS(31),
	SAOCAETANO(32), SAOPAULO(33), SPORT(34), VASCO(35), VITORIA(36);

	TimesEnum(int id) {
		this.idTime = id;
	}

	private int idTime;

	public int getId() {
		return this.idTime;
	}

	public static TimesEnum fromValue(Integer value) {
		for (TimesEnum time : TimesEnum.values()) {
			if (time.idTime == value)
				return time;
		}
		
		return null;
	}
}
