import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;

public class CurrencyConverter {

    private static final String EXCHANGE_RATES_API_URL = "https://api.exchangeratesapi.io/latest?base=USD";

    public double convert(double amount, String fromCurrency, String toCurrency) throws IOException {

        ExchangeRates rates = getExchangeRates();



        double rate = rates.getRates().get(toCurrency) / rates.getRates().get(fromCurrency);
        return amount * rate;
    }

    private ExchangeRates getExchangeRates() throws IOException {
        URL url = new URL(EXCHANGE_RATES_API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try {
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("Error al obtener los tipos de cambio: " + responseCode);
            }

            String responseBody = connection.getInputStream().toString(); // Leer la respuesta
            Gson gson = new Gson();
            return gson.fromJson(responseBody, ExchangeRates.class);
        } finally {
            connection.disconnect();
        }
    }
}
