import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { Testmono02SharedModule } from 'app/shared/shared.module';
import { Testmono02CoreModule } from 'app/core/core.module';
import { Testmono02AppRoutingModule } from './app-routing.module';
import { Testmono02HomeModule } from './home/home.module';
import { Testmono02EntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    Testmono02SharedModule,
    Testmono02CoreModule,
    Testmono02HomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    Testmono02EntityModule,
    Testmono02AppRoutingModule
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent]
})
export class Testmono02AppModule {}
