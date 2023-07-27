package com.dulearning.observability.aws.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.cloudwatch.CloudWatchAsyncClient;
import software.amazon.awssdk.services.cloudwatch.model.Dimension;
import software.amazon.awssdk.services.cloudwatch.model.MetricDatum;
import software.amazon.awssdk.services.cloudwatch.model.PutMetricDataRequest;
import software.amazon.awssdk.services.cloudwatch.model.StandardUnit;

import java.util.Collections;

@Service
public class CloudWatchService {
    @Autowired
    private CloudWatchAsyncClient cloudWatchAsyncClient;

    public void putMetricData(String namespace, String metricName, double dataPoint, String endpointName) {
        var dim = Dimension.builder().name("Endpoint").value(endpointName).build();
        var metricData = MetricDatum.builder().metricName(metricName).unit(StandardUnit.SECONDS).value(dataPoint).dimensions(Collections.singletonList(dim)).build();
        var metricRequest  = PutMetricDataRequest.builder().namespace(namespace).metricData(metricData).build();
        cloudWatchAsyncClient.putMetricData(metricRequest);
    }
}
