package health

import io.micronaut.context.annotation.Property
import io.micronaut.health.HealthStatus
import io.micronaut.management.endpoint.health.HealthEndpoint
import io.micronaut.management.health.indicator.HealthIndicator
import io.micronaut.management.health.indicator.HealthResult
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono

open class LivenessIndicator : HealthIndicator {

    @field:Property(name = "custom.liveness.threshold", defaultValue = "100")
    var limit: Int = 100

    init {
        println("${this.javaClass.simpleName} init'd")
    }

    override fun getResult(): Publisher<HealthResult> {
        println("${this.javaClass.simpleName} called")
        return Mono.just(HealthResult.builder("LIVENESS").status(HealthStatus.UP).build())
    }
}