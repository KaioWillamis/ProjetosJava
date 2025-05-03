package dio.spring_first_web.api.doc;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contato(){
        return new Contact(
            "Seu nome",
            "http://www.seusite.com.br",
            "voce@seusite.com.br");
    }

    private ApiInfoBuilder apiInfoBuilder(){
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Title - Rest Api");
        apiInfoBuilder.description("API exemplo de uso de Springboot REST API");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        apiInfoBuilder.license("Licença - Sua Empresa");
        apiInfoBuilder.licenseUrl("http://www.seusite.com.br");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;
    }

    @Bean
    public Docket detalheApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
            .apis(RequestHandlerSelectors.basePackage("pacote.comseus.controllers"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(this.infomacoesApi().build())
            .consumes(new HashSet<string>(Arrays.asList("application/json")))
            .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }
}
