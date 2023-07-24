package stage.epi.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login","/register/**").permitAll();
        http.authorizeRequests().antMatchers("/enseignant/**").permitAll();
        http.authorizeRequests().antMatchers("/etudiant/**").permitAll();
        http.authorizeRequests().antMatchers("/formation/**").permitAll();
        http.authorizeRequests().antMatchers("/secteur/**").permitAll();
        http.authorizeRequests().antMatchers("/stagiaire/**").permitAll();
        http.authorizeRequests().antMatchers("/admin/**").permitAll();
        http.authorizeRequests().antMatchers("/stage/**").permitAll();
        http.authorizeRequests().antMatchers("/commentaire/**").permitAll();
        http.authorizeRequests().antMatchers("/demmend/**").permitAll();

        http.authorizeRequests().antMatchers("/entreprise/**").permitAll();
        http.authorizeRequests().antMatchers("/upload/**").permitAll();

        http.authorizeRequests().antMatchers("/tache/**").permitAll();
        http.authorizeRequests().antMatchers("/demander/**").permitAll();
        http.authorizeRequests().antMatchers("/postuler/**").permitAll();

        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);
    }
}
