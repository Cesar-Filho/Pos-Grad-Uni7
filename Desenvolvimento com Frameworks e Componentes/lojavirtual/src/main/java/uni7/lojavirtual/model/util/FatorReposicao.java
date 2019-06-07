package uni7.lojavirtual.model.util;

import java.util.Random;

public class FatorReposicao {

  public static Long getRandomNumber(int min, int max) {

    Random r = new Random();
    return r.longs(min, (max + 1)).findFirst().getAsLong();

  }
}