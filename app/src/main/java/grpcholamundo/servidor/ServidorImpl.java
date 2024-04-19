package grpcholamundo.servidor;

import com.proto.saludo.SaludoServiceGrpc;
import com.proto.saludo.Holamundo.SaludoRequest;
import com.proto.saludo.Holamundo.SaludoResponse;

import io.grpc.stub.StreamObserver;

public class ServidorImpl extends SaludoServiceGrpc.SaludoServiceImplBase {
    @Override
    public void saludo(SaludoRequest request, StreamObserver<SaludoResponse> responseObserver) {
        SaludoResponse response = SaludoResponse.newBuilder().setResultado("Hola " + request.getNombre()).build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
