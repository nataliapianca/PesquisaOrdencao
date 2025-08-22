package exceptions;

import java.io.File;

public class ValidationUtils {
	

	public static void validarStringNaoVazia(String s, String campo) {
		if (s == null || s.trim().isEmpty()) {
			throw new DomainException("O campo " + campo + "não pode ser vazio");
		}
	}
	
	public static void validarArquivo(String caminho) {
	    ValidationUtils.validarStringNaoVazia(caminho, "caminho do arquivo");
	    
	    File arquivo = new File(caminho);
	    if (!arquivo.exists()) {
	        throw new DomainException("O arquivo " + caminho + " não existe.");
	    }
	    
	    if (!arquivo.canRead()) {
	        throw new DomainException("Não é possível ler o arquivo " + caminho + ".");
	    }
	}
	
}
