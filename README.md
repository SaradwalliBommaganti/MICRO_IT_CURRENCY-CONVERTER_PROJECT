**Currency Converter Application:-**

This is a Spring Boot-based REST API application that performs currency conversion using real-time exchange rates from an external API. The application accepts a source currency, target currency, and amount, then returns the converted amount based on current rates.


**Project Structure:-**

**com.currencyConverter**


├── controller


│ └── CurrencyController.java


├── model


│ ├── ConversionRequest.java


│ └── ConversionResponse.java


├── service


│ ├── CurrencyService.java


│ └── impl/CurrencyServiceImpl.java


└── CurrencyConverterApplication.java


 **How to Run:-**

1. **Clone the repository:**

   ```bash
   git clone https://github.com/SaradwalliBommaganti/MICRO_IT_CURRENCY-CONVERTER_PROJECT.git
   cd MICRO_IT_CURRENCY-CONVERTER_PROJECT


**Set environment variables or configure application.properties file with your API details:**
```
currency.api.url=https://your-exchange-api-url
currency.api.key=your_api_key_here
```


**Build and run the application:-**
~~~
mvn clean install
mvn spring-boot:run
~~~

**Access the application locally:-**

~~~
http://localhost:8082/api/currency/convert
~~~

**
API Endpoint Details
**

~~~
POST /api/currency/convert
~~~

**Request Body:-**

~~~
{
  "fromCurrency": "USD",
  "toCurrency": "INR",
  "amount": 100
}

~~~

**Response Body:-**

~~~
{
  "fromCurrency": "USD",
  "toCurrency": "INR",
  "originalAmount": 100.0,
  "convertedAmount": 8554.0497
}

~~~

~~~
Explanation:-

fromCurrency: The source currency code (e.g., USD).

toCurrency: The target currency code (e.g., INR).

amount: The numeric value to be converted.

convertedAmount: The computed value based on the real-time exchange rate fetched from the external API.

Key Classes Overview:-

ConversionRequest: Record that captures the input data for conversion.

ConversionResponse: Record that holds the result of the currency conversion.

CurrencyController: REST controller that handles POST requests to /convert.

CurrencyService: Interface defining the currency conversion method.

CurrencyServiceImpl: Service implementation that:

Constructs the external API request URL with base and target currencies.

Sets required HTTP headers including API key.

Parses the response to extract the exchange rate.

Calculates the converted amount and returns a ConversionResponse.

Notes:-

Ensure that the API key is active and the external exchange rate API is reachable.

Use Postman or curl to test the endpoint during development.
~~~


