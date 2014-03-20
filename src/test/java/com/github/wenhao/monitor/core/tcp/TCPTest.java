package com.github.wenhao.monitor.core.tcp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.monitor.core.tcp.model.Status;
import com.github.wenhao.monitor.core.tcp.model.TcpRequest;
import com.github.wenhao.monitor.core.tcp.model.TcpResponse;
import org.junit.Ignore;
import org.junit.Test;

public class TcpTest
{

    @Test
    @Ignore
    public void should_be_able_to_connect_tcp() throws Exception
    {
        // given

        // when
        Tcp tcp = TcpFactory.create();

        TcpRequest tcpRequest = new TcpRequest();
        tcpRequest.setHost("http://localhost");
        tcpRequest.setPort(8000);
        tcp.setRequest(tcpRequest);
        TcpResponse tcpResponse = tcp.send();

        // then
        assertThat(tcpResponse.getStatus(), is(Status.OK));
    }
}
