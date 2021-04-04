FROM node as builder
WORKDIR /frontend
ADD . .
RUN npm install
RUN npm run build

FROM nginx:stable-alpine as production
COPY ./nginx/nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=build /app.dist /usr/share/nginx/html
EXPOSE 8080
CMD ["nginx", "-g", "daemon off;"]