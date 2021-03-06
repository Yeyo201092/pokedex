package com.teambravos.pokedex.web.security;

import com.teambravos.pokedex.domain.service.PokemonUserService;
import com.teambravos.pokedex.web.security.filter.JwtFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


/**
 * En la clase security config se llevara a cabo toda la configuracion
 * accerca de la utenticacion del usuario y el jwt
 *
 *
 * @author: Luis alberto Vazquez
 * @since: 14/01/2021
 */
public class SecurityConfig {
/*


    @Autowired
    private PokemonUserService pokemonUserService;

    @Autowired
    private JwtFilterRequest jwtFilterRequest;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(pokemonUserService);
    }

*/

    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests().antMatchers("*//**//*authenticate").permitAll()
                .anyRequest().authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    */


}
