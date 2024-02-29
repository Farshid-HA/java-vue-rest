FROM node:20-slim

WORKDIR /src
COPY package*.json ./
RUN npm install
RUN npm install -g ts-node 
RUN npm install -g @vue/cli
RUN npm install chart.js
COPY . ./
EXPOSE 8081
CMD ["npm", "run", "serve"]