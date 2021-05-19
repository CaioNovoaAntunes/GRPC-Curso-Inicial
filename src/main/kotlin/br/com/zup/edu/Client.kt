package br.com.zup.edu

import io.grpc.ManagedChannelBuilder

fun main(){

    val channel = ManagedChannelBuilder
        .forAddress("localhost", 18080)
        .usePlaintext()
        .build()
    val request = FuncionarioRequest.newBuilder()
        .setNome("Adrian")
        .setCpf("8832482348238482")
        .setIdade(15)
        .setCargo(Cargo.GERENTE)
        .setSalario(2400.00)
        .addEnderecos(
            FuncionarioRequest.Endereco.newBuilder()
                .setCep("11724-060")
                .setLogradouro("Rua dos Tamarati dos calcados")
                .build()
        )
        .build()

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
    val response = client.cadastrarFuncionario(request)
    println(response)
}