package org.example;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class CurrencyConverterApp extends JFrame {
    private JTextField amountField;
    private JComboBox<String> fromCurrencyCombo;
    private JComboBox<String> toCurrencyCombo;
    private JLabel resultLabel;

    public CurrencyConverterApp() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();

        JLabel fromCurrencyLabel = new JLabel("From Currency:");
        fromCurrencyCombo = new JComboBox<>(getCurrencies());

        JLabel toCurrencyLabel = new JLabel("To Currency:");
        toCurrencyCombo = new JComboBox<>(getCurrencies());

        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        add(amountLabel);
        add(amountField);
        add(fromCurrencyLabel);
        add(fromCurrencyCombo);
        add(toCurrencyLabel);
        add(toCurrencyCombo);
        add(convertButton);
        add(resultLabel);
    }

    private String[] getCurrencies() {
        return new String[]{
                "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD",
                "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY",
                "COP", "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP",
                "FOK", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF",
                "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KID",
                "KMF", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD",
                "MMK", "MNT", "MOP", "MRU", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR",
                "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR",
                "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLE", "SOS", "SRD", "SSP", "STN", "SYP", "SZL", "THB", "TJS",
                "TMT", "TND", "TOP", "TRY", "TTD", "TVD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND",
                "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL"
        };
    }

    private void convertCurrency() {
        String apiKey = "56b1c478c165535c7b4ce464"; // Obtén tu API key gratuita en https://www.exchangerate-api.com/
        String baseCurrency = fromCurrencyCombo.getSelectedItem().toString();
        String targetCurrency = toCurrencyCombo.getSelectedItem().toString();
        double amountToConvert = Double.parseDouble(amountField.getText());

        double convertedAmount = CurrencyConverter.convertCurrency(apiKey, baseCurrency, targetCurrency, amountToConvert);

        if (convertedAmount != -1) {
            resultLabel.setText(amountToConvert + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
        } else {
            resultLabel.setText("Error en la conversión. Verifica tu API Key o la conexión a Internet.");
        }
    }


    public class CurrencyConverter {
        public static double convertCurrency(String apiKey, String baseCurrency, String targetCurrency, double amountToConvert) {
            try {
                URL url = new URL("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + baseCurrency + "/" + targetCurrency);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                double exchangeRate = jsonResponse.getDouble("conversion_rate");

                return amountToConvert * exchangeRate;
            } catch (Exception e) {
                e.printStackTrace();
                return -1; // Si hay un error, retorna -1 como valor inválido.
            }

        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverterApp().setVisible(true);
            }
        });
    }
}
