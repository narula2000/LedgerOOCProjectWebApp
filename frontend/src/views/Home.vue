<template>
<v-app class="theme--light">
<v-container>
  <div class="index">
    <v-app class="theme--dark">
      <v-row class="text-center">
        <v-col cols="12">

        </v-col>

        <v-col class="mb-4">
          <h1 class="display-2 font-weight-bold mb-3">
            Ledger Accounting
          </h1>
        </v-col>

        <v-col
                class="mb-5"
                cols="12"
        >
          <v-btn class="mr-3" x-large color="cyan" dark outlined>
          <router-link to="/register" tag="li">
          sign-up
            </router-link>

          </v-btn>

          <v-btn class="mr-3" x-large color="cyan" dark outlined>
          <router-link to="/login" tag="li"> sign-in
            </router-link>

          </v-btn>

        </v-col>

        <v-col
                class="mb-5"
                cols="12"
        >
        </v-col>

        <v-col
                class="mb-5"
                cols="12"
        >
        </v-col>
      </v-row>
    </v-app>
  </div>
</v-container>
</v-app>
</template>

<script>
  export default {
    computed: {
      loggedIn() {
        return this.$store.state.auth.status.loggedIn;
      }
    },
    created() {
      if (this.loggedIn) {
        this.$router.push('/Profile');
      }
    }
  };
</script>