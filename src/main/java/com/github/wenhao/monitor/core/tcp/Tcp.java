package com.github.wenhao.monitor.core.tcp;

import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import com.github.wenhao.monitor.core.tcp.model.Status;
import com.github.wenhao.monitor.core.tcp.model.TcpRequest;
import com.github.wenhao.monitor.core.tcp.model.TcpResponse;
import org.apache.commons.io.IOUtils;
import org.apache.commons.net.SocketClient;
import org.apache.commons.net.echo.EchoTCPClient;


public class Tcp
{

    private TcpRequest request;
    private EchoTCPClient echoTCPClient;

    public Tcp(EchoTCPClient echoTCPClient)
    {
        this.echoTCPClient = echoTCPClient;
    }

    public void setRequest(TcpRequest request)
    {
        this.request = request;
    }

    public TcpResponse send()
    {
        try {
            echoTCPClient.setDefaultTimeout(request.getTimeout());
            echoTCPClient.connect(request.getHost(), request.getPort());
            String content = IOUtils.toString(echoTCPClient.getInputStream());
            return new TcpResponse(Status.OK, content);
        } catch (IOException e) {
            return new TcpResponse(Status.FAIL, EMPTY);
        } finally {
            closeSocket(echoTCPClient);
        }
    }

    private void closeSocket(SocketClient socketClient)
    {
        try {
            socketClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
