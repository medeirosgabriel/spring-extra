package com.ufcg.learningjwt.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenDTO {
	
	private String type;
	private String token;
	
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
}
