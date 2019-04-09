package com.va.laundryjunction.config;


import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket newApiDocket() {

		return new Docket(DocumentationType.SWAGGER_2).groupName("laundry-junction-service")
				.apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.va.laundryjunction.controller"))
				.paths(PathSelectors.regex(".*"))
				.build().useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.POST, getResponseMessages())
				.globalResponseMessage(RequestMethod.GET, getResponseMessages());
	}

	private List<ResponseMessage> getResponseMessages(){
		return Arrays.asList(new ResponseMessageBuilder()
						.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
						.message(HttpStatus.INTERNAL_SERVER_ERROR.name())
						.build(),
				new ResponseMessageBuilder()
						.code(HttpStatus.UNPROCESSABLE_ENTITY.value())
						.message(HttpStatus.UNPROCESSABLE_ENTITY.name())
						.build(),
				new ResponseMessageBuilder()
						.code(HttpStatus.OK.value())
						.message(HttpStatus.OK.name())
						.build(),
				new ResponseMessageBuilder()
						.code(HttpStatus.UNAUTHORIZED.value())
						.message(HttpStatus.UNAUTHORIZED.name())
						.build(),
				new ResponseMessageBuilder()
						.code(HttpStatus.NOT_FOUND.value())
						.message(HttpStatus.NOT_FOUND.name())
						.build());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("laundry-junction-service")
				.description("laundry junction service").version("1.0.0").build();
	}
}
