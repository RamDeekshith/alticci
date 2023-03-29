<br>
<h1 align="center">
Alticci Sequence Calculator (Backend) ⚛️
</h1>
<br>

## 💬 About the repository

The Alticci Sequence Calculator calculates an Alticci sequence value based on a passed index, which is defined as follows:
n=0 => a(0) = 0

n=1 => a(1) = 1

n=2 => a(2) = 1

n>2 => a(n) = a(n-3) + a(n-2)

The core service takes advantage of past calculations to speed up future calculations through caching (using memoization). In addition to the main service, there is also a service by Spring Cache, to demonstrate the performance difference when memoization is not used.

## ⚠ Prerequisites for project execution

* Java 11 or higher versions
* Maven
* The below steps need to run in GitBash
   * SDKMan install instructions: [SDKMan](https://sdkman.io/install)
   * Download GitBash: [GitBash](https://git-scm.com/download/win)
   * Download ConEmu [a better Windows terminal](https://conemu.github.io/)
   * Zip [you need this package to install SDKMan](http://gnuwin32.sourceforge.net/packa)
   * Quarkus Install guide [Install](https://quarkus.io/get-started/)
 
## Download attached zip file and go to path:

```
cd quarkus-spring-web-quickstart

 mvn clean install
```

## 📌 How to use it?

To run the project, enter the following command in the root directory:
```
mvn quarkus:dev
```

* Run attached file:Alticci_Seq_html
* Service URL:http://localhost:8080/alticci
* Service Parameters: 4

After building the application, access [Swagger](http://localhost:8080/q/swagger-ui/index.html#/) to test the endpoints.

## 📲 Services available for testing

### Alticci Sequence Number
```
Method: GET
URL: http://localhost:8080/alticci/{n}
{n}: index to be passed.
```

### Check Memoized Cache
```
Method: POST
URL: http://localhost:8080/alticci/clearMemoCache
```

### Alticci Sequence Number with Spring Cache
```
Method: GET
URL: http://localhost:8080/alticci/springCache/{n}
{n}: index to be passed.
```

