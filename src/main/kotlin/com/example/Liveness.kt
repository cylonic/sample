package com.example

import health.LivenessIndicator
import io.micronaut.context.annotation.Requires
import io.micronaut.management.endpoint.health.HealthEndpoint
import io.micronaut.management.health.indicator.annotation.Liveness
import jakarta.inject.Singleton


@Liveness
@Singleton
@Requires(bean = HealthEndpoint::class)
@Requires(property = HealthEndpoint.PREFIX + ".custom.liveness.enabled", value = "true", defaultValue = "false")
class CustomLivenessIndicator : LivenessIndicator()