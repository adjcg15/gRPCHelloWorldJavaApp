package grpcholamundo.cliente;

import com.proto.saludo.SaludoServiceGrpc;
import com.proto.saludo.Holamundo.SaludoRequest;
import com.proto.saludo.Holamundo.SaludoResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8080;

        ManagedChannel channel = ManagedChannelBuilder
            .forAddress(host, port)
            .usePlaintext()
            .build();

        SaludoServiceGrpc.SaludoServiceBlockingStub stub = SaludoServiceGrpc.newBlockingStub(channel);

        SaludoRequest request = SaludoRequest.newBuilder().setNombre("Angel").build();

        SaludoResponse response = stub.saludo(request);
        System.out.println("Respuesta RPC: " + response.getResultado());

        System.out.println("Apagando...");
        channel.shutdown();
    }
}
