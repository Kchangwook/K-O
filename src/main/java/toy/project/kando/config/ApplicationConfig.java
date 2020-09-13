package toy.project.kando.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {DBConfig.class, MybatisConfig.class})
// @ComponentScan(basePackages = {"toy.project.kando"})
public class ApplicationConfig {
}
