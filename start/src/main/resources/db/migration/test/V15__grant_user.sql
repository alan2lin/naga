

GRANT CONNECT, CREATE, TEMPORARY ON DATABASE mybbs TO mybbs;
GRANT USAGE, CREATE ON SCHEMA public TO mybbs;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO mybbs;
ALTER DEFAULT PRIVILEGES FOR USER mybbs IN SCHEMA public GRANT ALL ON TABLES TO mybbs;
