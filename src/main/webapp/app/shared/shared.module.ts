import { NgModule } from '@angular/core';
import { Testmono02SharedLibsModule } from './shared-libs.module';
import { AlertComponent } from './alert/alert.component';
import { AlertErrorComponent } from './alert/alert-error.component';
import { HasAnyAuthorityDirective } from './auth/has-any-authority.directive';

@NgModule({
  imports: [Testmono02SharedLibsModule],
  declarations: [AlertComponent, AlertErrorComponent, HasAnyAuthorityDirective],
  exports: [Testmono02SharedLibsModule, AlertComponent, AlertErrorComponent, HasAnyAuthorityDirective]
})
export class Testmono02SharedModule {}
