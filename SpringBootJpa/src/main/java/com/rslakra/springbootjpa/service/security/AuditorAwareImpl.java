package com.rslakra.springbootjpa.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Aug 31, 2021 20:45:41
 */
public class AuditorAwareImpl implements AuditorAware<String> {

    // LOGGER
    private static Logger LOGGER = LoggerFactory.getLogger(AuditorAwareImpl.class);
    private final Optional<String> ANONYMOUS = Optional.of("ANONYMOUS");

    /**
     * <code>Returns ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()</code>
     *
     * @return
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        LOGGER.debug("+getCurrentAuditor()");
        Optional<String> loggedInUser = ANONYMOUS;
        LOGGER.debug("-getCurrentAuditor(), loggedInUser:{}", loggedInUser);
        return loggedInUser;
    }
}
