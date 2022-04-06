package com.ufcg.learningjwt.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenDTO {
	
	private String type;
	private String token;
	
	public TokenDTO() {}
	
	public TokenDTO(TokenDTO tokenDTO) {
		this.token = tokenDTO.getToken();
		this.type = tokenDTO.getType();
	}

	public String getType() {
		return type;
	}

	public String getToken() {
		return token;
	}

	public TokenDTO builder() {
		return this;
	}
	
	public TokenDTO token(String token) {
		this.token = token;
		return this;
	}
	
	public TokenDTO type(String type) {
		this.type = type;
		return this;
	}
	
	
	public TokenDTO build() {
		TokenDTO token =  new TokenDTO(this);
		return token;
	}
}
