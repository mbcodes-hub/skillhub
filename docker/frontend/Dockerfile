# Étape 1 : build de l'app Angular
FROM node:18-alpine as build

WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . /app
RUN npm run build --prod

# Étape 2 : servir le build via nginx
FROM nginx:alpine
COPY --from=build /app/dist/skillhub /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
