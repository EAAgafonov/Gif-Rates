# Gif Rate Service
Service that calls the exchange rate service and return a gif in response
If rate has grown from yesterday, it will return a gif with a "rich" tag,
otherwise with a "broke" tag

Entry point: http://localhost:8080/

## Prerequisites
In order to run this application you need to install: Docker.

## How to run it?

Type in root directory <code>$ gradle build</code>

An entire application can be run with a command in a terminal:

<code>$ docker image build -t gifservice .</code>

If you want to stop it use following command:

<code>$ docker stop NAME</code>



