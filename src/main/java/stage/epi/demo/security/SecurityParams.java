package stage.epi.demo.security;

public interface SecurityParams {
     String JWT_HEADER_NAME="Authorization";
  String SECRET="ITGATE";
   long EXPIRATION=10000*24*3600;
   String HEADER_PREFIX="Bearer ";
}
