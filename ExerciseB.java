import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExerciseB {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String inputString = scanner.nextLine().trim();
    scanner.close();

    System.out.println(findMaxSubstringLength(inputString));
  }

  public static int findMaxSubstringLength(String inputString) {
    int stringLength = inputString.length();
    int maxSubstringLength = 0;

    // Armazena caracteres únicos
    Set<Character> uniqueCharacters = new HashSet<>();

    // Ponteiros para a janela deslizante
    int left = 0;

    // Primeira passagem: encontra substrings com caracteres distintos
    for (int right = 0; right < stringLength; right++) {
      // Remove os caracteres repetidos movendo o início da janela
      while (uniqueCharacters.contains(inputString.charAt(right))) {
        uniqueCharacters.remove(inputString.charAt(left));
        left++;
      }
      // Adiciona o caractere atual aos caracteres únicos
      uniqueCharacters.add(inputString.charAt(right));
      // Atualiza o comprimento máximo da substring encontrada
      maxSubstringLength = Math.max(maxSubstringLength, right - left + 1);
    }

    // Segunda passagem: considera a reversão de uma substring
    for (int i = 0; i < stringLength; i++) {
      uniqueCharacters.clear(); // Reinicia o conjunto de caracteres únicos
      left = i;
      for (int right = i; right < stringLength; right++) {
        // Remove os caracteres repetidos movendo o início da janela
        while (uniqueCharacters.contains(inputString.charAt(right))) {
          uniqueCharacters.remove(inputString.charAt(left));
          left++;
        }
        // Adiciona o caractere atual ao conjunto de caracteres únicos
        uniqueCharacters.add(inputString.charAt(right));

        // Tenta combinar a substring atual com outras substrings à direita
        for (int j = right + 1; j < stringLength; j++) {
          Set<Character> combinedCharacters = new HashSet<>(uniqueCharacters);
          int k = j;
          // Adiciona caracteres à combinação enquanto forem únicos
          while (k < stringLength && !combinedCharacters.contains(inputString.charAt(k))) {
            combinedCharacters.add(inputString.charAt(k));
            k++;
          }
          // Atualiza o comprimento máximo se a combinação for válida
          maxSubstringLength = Math.max(maxSubstringLength, (right - left + 1) + (k - j));
        }
      }
    }

    return maxSubstringLength;
  }
}