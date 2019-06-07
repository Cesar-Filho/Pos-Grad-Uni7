package uni7.persistencia.bancario.util;

import java.io.Serializable;
import java.util.Date;

public class QueryPeriodo implements Serializable {
  private static final long serialVersionUID = 1L;
  private Date dataInicial;
  private Date dataFinal;

  public Date getDataInicial() {
    return dataInicial;
  }

  public void setDataInicial(Date dataInicial) {
    this.dataInicial = dataInicial;
  }

  public Date getDataFinal() {
    return dataFinal;
  }

  public void setDataFinal(Date dataFinal) {
    this.dataFinal = dataFinal;
  }
}