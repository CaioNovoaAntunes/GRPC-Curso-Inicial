
import br.com.zup.edu.Cargo
import br.com.zup.edu.FuncionarioRequest
import java.io.FileInputStream
import java.io.FileOutputStream


fun main() {

    val request = FuncionarioRequest.newBuilder()
        .setNome("Adrian")
        .setCpf("8832482348238482")
        .setCargo(Cargo.GERENTE)
        .setSalario(2400.00)
        .setIdade(15)
        .addEnderecos(
            FuncionarioRequest.Endereco.newBuilder()
                .setCep("11724-060")
                .setLogradouro("Rua dos Tamarati dos calçados")
                .build()
        )
        .build()

    println(request)
    request.writeTo(FileOutputStream("request_grpc.bin"))


    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("request_grpc.bin"))

    println("=============Lendo Arquivo EM DISCO===============")
    println(request2)
    println("=============Lendo Arquivo em Disco Modificado ========")
    request2.setCargo(Cargo.QA)
    println(request2)
}