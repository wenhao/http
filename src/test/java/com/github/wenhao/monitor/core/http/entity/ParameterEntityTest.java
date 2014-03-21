package com.github.wenhao.monitor.core.http.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.junit.Test;

public class ParameterEntityTest
{

    @Test
    public void should_be_able_to_get_parameter_entity() throws Exception
    {
        // given
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.addParameter("test", "test");


        // when
        ParameterEntity parameterEntity = new ParameterEntity();


        // then
        assertThat(parameterEntity.isApplicable(httpRequest), is(true));
    }
}
